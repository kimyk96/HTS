package com.hts.market.global.config.security.auth;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.entity.MemRoleEntity;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.member.repo.MemRoleRepo;
import com.hts.market.domain.member.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MemDetailsService implements UserDetailsService {
    @Autowired MemRepo memRepo;
    @Autowired MemRoleRepo memRoleRepo;
    @Autowired RoleRepo roleRepo;


    @Override
    public UserDetails loadUserByUsername(String memUsername) throws UsernameNotFoundException {
        // memUsername 으로 유저 확인
        MemEntity memEntity = memRepo.loadUserByUsername(memUsername);
        // memUsername.memNo 로 권한 확인
        List<MemRoleDto.Read> roleList = memRoleRepo.findAllById(memEntity.getMemNo());
        // 권한명 스트링리스트 저장
        Collection<GrantedAuthority> roles = new ArrayList<>();
        roleList.forEach((role) -> roles.add(new GrantedAuthority() {
            @Override public String getAuthority() {
                return roleRepo.findById(role.getRoleNo()).getRoleName();
            }
        }));
        return new MemDetails(memEntity, roles);
    }
}
