package com.liferayinaction.portlet;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloYouPortlet extends GenericPortlet {
	
	protected String editJSP;
	protected String viewJSP;
	
	private static Log _log = LogFactory.getLog(HelloYouPortlet.class);
	
	public void init() throws PortletException {
		editJSP = getInitParameter("edit-jsp");
		viewJSP = getInitParameter("view-jsp");
	}

	public void doView(RenderRequest renderRequest, 
			RenderResponse renderResponse) 
					throws IOException, PortletException {
		PortletPreferences prefs = renderRequest.getPreferences();
		String username = (String) prefs.getValue("name", "no");
		if (username.equalsIgnoreCase("no")) {
			username = "";
		}
		renderRequest.setAttribute("userName", username);
		include(viewJSP, renderRequest, renderResponse);
	}

	private void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
		
	}
}
