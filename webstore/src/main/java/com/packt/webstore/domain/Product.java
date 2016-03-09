package com.packt.webstore.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webstore.validator.Category;
import com.packt.webstore.validator.ProductId;

@XmlRootElement
public class Product {
	
	  @Pattern(regexp="P[0-9]+",message="{Pattern.Product.productId.validation}")
	  @ProductId
	  private String productId;
	  
	  @Size(min=4,max=50,message="{Size.Product.name.validation}")
	  private String name;
	  
	  @Min(value=0,message="Min.Product.unitPrice.validation}")
	  @Digits(integer=8,fraction=2,message="{Digits.Product.unitPrice.validation}")
	  @NotNull(message="{NotNull.Product.unitPrice.validation}")
	  private BigDecimal unitPrice;
	  
	  
	  private String description;
	  private String manufacturer;
	  
	  @NotEmpty(message="{NotEmpty.Product.category.validation}")
	  @Category
	  private String category;

	  @Min(value=0,message="{Min.Product.unitsInStock.validation}")
	  private long unitsInStock;
	  
	  private long unitsInOrder;
	  private boolean discontinued;
	  private String condition;
	  
	  @JsonIgnore
	  private MultipartFile  productImage;
	  @JsonIgnore
	  private MultipartFile  productManual;

	  public Product() {
	    super();
	}
	  public Product(String productId, String name, BigDecimal unitPrice) {
		    this.productId = productId;
		    this.name = name;
		    this.unitPrice = unitPrice;
		  }
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public long getUnitsInOrder() {
		return unitsInOrder;
	}
	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}
	public boolean isDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	@XmlTransient
	public MultipartFile getProductManual() {
		return productManual;
	}
	public void setProductManual(MultipartFile productManual) {
		this.productManual = productManual;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (discontinued ? 1231 : 1237);
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + (int) (unitsInOrder ^ (unitsInOrder >>> 32));
		result = prime * result + (int) (unitsInStock ^ (unitsInStock >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (condition == null) {
			if (other.condition != null) {
				return false;
			}
		} else if (!condition.equals(other.condition)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (discontinued != other.discontinued) {
			return false;
		}
		if (manufacturer == null) {
			if (other.manufacturer != null) {
				return false;
			}
		} else if (!manufacturer.equals(other.manufacturer)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (productId == null) {
			if (other.productId != null) {
				return false;
			}
		} else if (!productId.equals(other.productId)) {
			return false;
		}
		if (unitPrice == null) {
			if (other.unitPrice != null) {
				return false;
			}
		} else if (!unitPrice.equals(other.unitPrice)) {
			return false;
		}
		if (unitsInOrder != other.unitsInOrder) {
			return false;
		}
		if (unitsInStock != other.unitsInStock) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", unitsInOrder=" + unitsInOrder + ", discontinued=" + discontinued + ", condition="
				+ condition + "]";
	}
	  
	
}