/**
 * Created by wrket on 31-Oct-16.
 */
//public class Cookies {
//    @RequestMapping("/myPath.htm")
//    public Cookies add(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        myServiceMethodSettingCookie(request, response);        //Do service call passing the response
//        return new ModelAndView("CustomerAddView");
//
//
//        // service method
//        myServiceMethodSettingCookie(HttpServletRequest request, HttpServletResponse response) {
//            final String cookieName = "my_cool_cookie";
//            final String cookieValue = "my cool value here !";  // you could assign it some encoded value
//            final Boolean useSecureCookie = new Boolean(false);
//            final int expiryTime = 60 * 60 * 24;  // 24h in seconds
//            final String cookiePath = "/";
//
//            Cookie myCookie = new Cookie(cookieName, cookieValue);
//
//            cookie.setSecure(useSecureCookie.booleanValue());  // determines whether the cookie should only be sent using a secure protocol, such as HTTPS or SSL
//
//            cookie.setMaxAge(expiryTime);  // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits. A zero value causes the cookie to be deleted.
//
//            cookie.setPath(cookiePath);  // The cookie is visible to all the pages in the directory you specify, and all the pages in that directory's subdirectories
//
//            response.addCookie(myCookie);
//        }
//    }
//}
