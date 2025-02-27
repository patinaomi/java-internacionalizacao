package br.com.fiap.Aula001.domains;

import br.com.fiap.Aula001.domains.roles.PermissaoEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@With
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Permissao> permissaoList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> papeis = this.permissaoList.stream()
                .map(Permissao::getPermissaoEnum)
                .map(PermissaoEnum::name)
                .map(SimpleGrantedAuthority::new)
                .toList();

        List<SimpleGrantedAuthority> autoridades = new java.util.ArrayList<>(this.permissaoList.stream()
                .map(Permissao::getPermissaoEnum)
                .map(PermissaoEnum::getAutoridades)
                .flatMap(List::stream)
                .map(SimpleGrantedAuthority::new)
                .toList());
        autoridades.addAll(papeis);
        return autoridades;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

}
