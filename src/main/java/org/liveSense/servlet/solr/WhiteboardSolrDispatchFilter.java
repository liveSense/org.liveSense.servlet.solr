package org.liveSense.servlet.solr;

import org.apache.felix.scr.annotations.*;
import org.apache.solr.core.CoreContainer;
import org.apache.solr.servlet.SolrDispatchFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component(metatype = true, immediate = true)
@Service(value = { Filter.class })
@Properties(value = {
		@Property(name = "filter-name", value = "Solr filter"),
		@Property(name = "pattern", value = ".*"),
		@Property(name = "urlPatterns", value = { "/solr" }, unbounded = PropertyUnbounded.ARRAY, cardinality = Integer.MAX_VALUE),
		@Property(name = "servletNames", value = { "solr-admin-content-servlet" }, unbounded = PropertyUnbounded.ARRAY, cardinality = Integer.MAX_VALUE),
 })

public class WhiteboardSolrDispatchFilter extends SolrDispatchFilter implements Filter {

	@Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY, policy = ReferencePolicy.DYNAMIC)
	CoreContainer container;

	@Activate
	protected void activate() {
		this.cores = container;
		this.pathPrefix = "/solr";
	}

	@Override
	public void init(FilterConfig config) throws ServletException
	{
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest)
		//if (request.getPpathPrefix)
		doFilter(request, response, chain, false);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain, boolean retry) throws IOException, ServletException {
		super.doFilter(request, response, chain, retry);
	}
}
