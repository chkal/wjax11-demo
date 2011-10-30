package de.chkal.wjax11.web;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import de.chkal.wjax11.service.BookImageService;

@Named
@RequestScoped
@URLMapping(id = "bookImage", pattern = "/images/book/#{bookImageBean.isbn}.jpg", viewId = "/faces/home.xhtml")
public class BookImageBean {

    private Long isbn;
    
    @Inject
    private BookImageService bookImageService;
    
    @URLAction
    public void getImage() throws IOException {

        byte[] image = bookImageService.getBookImage(isbn);
        if(image == null) {
            PrettyContext.getCurrentInstance().sendError(404);
            return;
        }

        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        
        response.setContentType("image/jpg");
        response.getOutputStream().write(image);
        response.flushBuffer();
        
        facesContext.responseComplete();
        
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
    
}
