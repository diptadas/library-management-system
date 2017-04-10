package bat.example;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieRes {

	public static String getCookieValue(HttpServletRequest request, String key)
	{
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();

		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				cookie = cookies[i];
				if (cookie.getName().equals(key)) return cookie.getValue();
			}
		}

		return null;
	}

	public static void setCookie(HttpServletResponse response, String key, String value)
	{
		Cookie c = new Cookie(key, value);
		c.setMaxAge(60 * 60 * 24);
		response.addCookie(c);
	}

	public static void clearCookie(HttpServletResponse response, String key)
	{
		Cookie c = new Cookie(key, "");
		c.setMaxAge(0);
		response.addCookie(c);
	}

}
