package LapTrinhWeb.SpringBoot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SiteAuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// In a real scenario with Spring Security, the security filter chain handles this.
		// However, to demonstrate Interceptor usage as requested:
		
		String requestUri = request.getRequestURI();
		
		// Example logic:
		// If we were managing session manually without Spring Security:
		// if (session.getAttribute("user") == null) {
		//    response.sendRedirect("/login");
		//    return false;
		// }
		
		// Since we use Spring Security, this Interceptor runs AFTER Spring Security filters 
		// (if it passes them). 
		// We can add some custom logic here, e.g., logging or checking specific custom attributes.
		
		System.out.println("Interceptor: Processing request for " + requestUri);
		
		// Logic simulation mostly for demonstration since SecurityConfig handles the real security
		if (requestUri.startsWith("/admin")) {
			// Check if user has admin role (mock logic or checking actual security context)
			// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			// if (auth != null && auth.isAuthenticated() && !hasAdminRole(auth)) {
			//     response.sendRedirect("/login?error=access_denied");
			//     return false;
			// }
		}

		return true;
	}
}
