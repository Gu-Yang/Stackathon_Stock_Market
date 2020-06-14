//package com.gy.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.gy.entity.StockMarketUserDetails;
//import com.gy.entity.User;
//import com.gy.utils.JwtUtils;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collection;
//
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//        super.setFilterProcessesUrl("/auth/login");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException {
//
//        try {
//            User loginUser = new ObjectMapper().readValue(request.getInputStream(), User.class);
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // 成功验证后调用的方法
//    // 如果验证成功，就生成token并返回
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//
//        StockMarketUserDetails jwtUser = (StockMarketUserDetails) authResult.getPrincipal();
//        System.out.println("jwtUser:" + jwtUser.toString());
//
//        String role = "";
//        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
//        for (GrantedAuthority authority : authorities){
//            role = authority.getAuthority();
//        }
//
//        String token = JwtUtils.generateJsonWebToken(jwtUser.getUsername(), role);
//        //String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
//        // 返回创建成功的token
//        // 但是这里创建的token只是单纯的token
//        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        String tokenStr = JwtTokenUtils.TOKEN_PREFIX + token;
//        response.setHeader("token",tokenStr);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
//    }
//}