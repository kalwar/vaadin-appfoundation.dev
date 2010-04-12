package org.vaadin.appfoundation.view;

import java.io.Serializable;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;

/**
 * Interface which all main views should implement
 * 
 * @author Kim
 * 
 */
public abstract class AbstractView<A extends ComponentContainer> extends
        CustomComponent implements Serializable {

    private static final long serialVersionUID = -1420553541682132603L;

    private A content;

    protected AbstractView(A layout) {
        setContent(layout);
        setSizeFull();
    }

    /**
     * This method is called when the view is activated.
     */
    public abstract void activated(Object... params);

    /**
     * This method is called when the view is deactivated via the
     * {@link ViewHandler}.
     */
    public abstract void deactivated(Object... params);

    /**
     * Set a new content container. Default value is the object provided as
     * parameter to the constructor.
     * 
     * @param content
     */
    protected void setContent(A content) {
        this.content = content;
        setCompositionRoot(content);
    }

    /**
     * Get the content container. Default value is the object provided as
     * parameter to the constructor.
     * 
     * @param content
     */
    protected A getContent() {
        return content;
    }

}
