package com.trainingExample.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/country" )
@WebFilter(value = { "/country" }, dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD,
		DispatcherType.INCLUDE })
public class CountryFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter-Locale: " + Locale.getDefault().getCountry());
		HttpServletRequest hReq = (HttpServletRequest) request;
		Locale locale_session = (Locale) hReq.getSession().getAttribute("Locale");
		if (locale_session == null) {
			if (Locale.getDefault().getCountry().equals("IN")) {
				chain.doFilter(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("");
				rd.include(request, response);
				response.getWriter().println("<h3 align=center> Only Indians are allowed here.");
			}
		}
		System.out.println("filter-locale_session: "+locale_session.getCountry());
		if (locale_session.getCountry().equals("IN")) {
				chain.doFilter(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("");
				rd.include(request, response);
				response.getWriter().println("<h3 align=center> Only Indians are allowed here.");
			}
			

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

		/*if (locale.getCountry().equals("IN")) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.include(request, response);
			response.getWriter().println("<h3 align=center> Only Indians are allowed here.");
		}*/
	}

}
