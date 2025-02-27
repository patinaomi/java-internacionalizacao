package br.com.fiap.Aula001.domains;

import br.com.fiap.Aula001.domains.roles.PermissaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Permissao implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private PermissaoEnum permissaoEnum;

    @Override
    public String getAuthority() {
        return this.permissaoEnum.name();
    }
}
