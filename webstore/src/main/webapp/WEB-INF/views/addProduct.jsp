<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

  <section class="container">
      <div>
		<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">logout</a>
	</div>
	<div class="pull-right" style="padding-right:50px">
	  <a href="?language=en" >English</a>|<a href="?language=nl" >Dutch</a>|<a href="?language=ta" >Tamil</a>
	</div>
    <form:form  modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
      <fieldset>
        <legend>Add new product</legend>

        <div class="form-group">
          <label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message code="addProduct.form.productId.label"/></label>
          <div class="col-lg-10">
            <form:input id="productId" path="productId" type="text" class="form:input-large"/>
            <form:errors path="productId" cssClass="text-danger"></form:errors>
          </div>
          <label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code="addProduct.form.productName.label"/></label>
          <div class="col-lg-10">
            <form:input id="name" path="name" type="text" class="form:input-large"/>
            <form:errors path="name" cssClass="text-danger"></form:errors>
          </div>
          <label class="control-label col-lg-2 col-lg-2" for="unitPrice"><spring:message code="addProduct.form.productUnitPrice.label"/></label>
          <div class="col-lg-10">
            <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
            <form:errors path="unitPrice" cssClass="text-danger"></form:errors>
          </div>
          <label class="control-label col-lg-2 col-lg-2" for="manufacturer"><spring:message code="addProduct.form.productManufacturer.label"/></label>
          <div class="col-lg-10">
            <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
          </div>
          <label class="control-label col-lg-2 col-lg-2" for="category"><spring:message code="addProduct.form.productCategory.label"/></label>
          <div class="col-lg-10">
            <form:input id="category" path="category" type="text" class="form:input-large"/>
             <form:errors path="category" cssClass="text-danger"></form:errors>
          </div>
          <label class="control-label col-lg-2 col-lg-2" for="unitsInStock"><spring:message code="addProduct.form.productUnitsInStock.label"/></label>
          <div class="col-lg-10">
            <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
             <form:errors path="unitsInStock" cssClass="text-danger"></form:errors>
          </div>
<!-- following field commented out ---Disallowed field in InitBinder -->
          <!-- label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Units In Order</label-->
          <!-- div class="col-lg-10">
            <form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>
          </div-->
        </div>
        <div class="form-group">
          <label class="control-label col-lg-2" for="description"><spring:message code="addProduct.form.productDescription.label"/></label>
          <div class="col-lg-10">
            <form:textarea id="description" path="description" rows = "2"/>
          </div>
        </div>

       
        <div class="form-group">
          <label class="control-label col-lg-2" for="condition"><spring:message code="addProduct.form.productCondition.label"/></label>
          <div class="col-lg-10">
            <form:radiobutton path="condition" value="New" />New 
            <form:radiobutton path="condition" value="Old" />Old 
            <form:radiobutton path="condition" value="Refurbished" />Refurbished
          </div>
        </div>
        
        <div class="form-group">
  			<label class="control-label col-lg-2" for="productImage"><spring:message code="addProdcut.form.productImage.label"/></label>
  			<div class="col-lg-10">
    			<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
  			</div>
		</div>

        <div class="form-group">
  			<label class="control-label col-lg-2" for="productManual"><spring:message code="addProdcut.form.productManual.label"/></label>
  			<div class="col-lg-10">
    			<form:input id="productImage" path="productManual" type="file" class="form:input-large" />
  			</div>
		</div>

        
        <div class="form-group">
          <div class="col-lg-offset-2 col-lg-10">
            <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
          </div>
        </div>
      </fieldset>
    </form:form>
  </section>
