package com.bichcon.pe.app.security;

import com.bichcon.pe.app.dao.IUsuarioDAO;
import com.bichcon.pe.app.entity.Rol;
import com.bichcon.pe.app.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findByEmail(username);

        if (usuario != null)
            return new User(usuario.getEmail(), usuario.getContrasenia(), mapearRoles(usuario.getRoles()));
        else throw new UsernameNotFoundException("No existe el usuario " + username);
    }

    public Collection<? extends SimpleGrantedAuthority> mapearRoles(Set<Rol> roles) {
        return roles.stream().map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombre())).collect(Collectors.toSet());
    }
}
