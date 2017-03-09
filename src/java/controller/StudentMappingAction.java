/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Data;
import model.StudentForm;


import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Ismael Nascimento
 */
public class StudentMappingAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success", List="list", Add="add", Save="save", Delete="delete", Edit="edit", Update="update";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward StudentList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        ArrayList arr = new Data().getAllStudents();
        request.setAttribute("list", arr);
        return mapping.findForward(List);
    }
    
    public ActionForward StudentAdd(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        return mapping.findForward(Add);
    }
    
    public ActionForward StudentSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        Data data = new Data();
        StudentForm sf = new StudentForm();
        
        if(data.AddStudent(sf))
        {
            System.out.println("Action add sucessfully");
        }
        else
        {
            System.out.println("Action add not sucessfully");
        }
        
        return mapping.findForward(Save);
    }
    
    public ActionForward StudentDelete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        Data data = new Data();
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(data.DeleteStudent(id))
        {
            System.out.println("Action delete sucessfully");
        }
        else
        {
            System.out.println("Action delete not sucessfully");
        }
        
        return mapping.findForward(Delete);
    }
    
    public ActionForward StudentEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        Data data = new Data();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("ID = " + id);
        ArrayList<StudentForm> sf = data.getStudent(id);
        request.setAttribute("listEdit", sf);
        
        return mapping.findForward(Edit);
    }
    
    public ActionForward StudentUpdate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        StudentForm sf = new StudentForm();
        Data data = new Data();
        
        if(data.UpdateStudent(sf))
        {
            System.out.println("Action update sucessfully");
        }
        else
        {
            System.out.println("Action update not sucessfully");
        }
               
        return mapping.findForward(Update);
    }
}
