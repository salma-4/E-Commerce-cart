<!-- Check if the product has been added to the cart -->
<%@include file="header.jsp" %>

<% Boolean addedToCart = (Boolean) request.getSession().getAttribute("addedToCart");
   if (addedToCart != null && addedToCart) { %>
    <!-- JavaScript alert to show the message -->
    <script>
        alert('Product Added to Cart!\nPrice: <%= request.getSession().getAttribute("addedProductPrice") %>');
    </script>

<% // Clear the session attributes to prevent displaying the message on refresh
   request.getSession().removeAttribute("addedToCart");
   request.getSession().removeAttribute("addedProductPrice");
   } %>

<%@include file="footer.jsp"%>
