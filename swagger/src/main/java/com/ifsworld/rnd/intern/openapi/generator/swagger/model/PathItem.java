package com.ifsworld.rnd.intern.openapi.generator.swagger.model;

import com.ifsworld.rnd.intern.openapi.generator.swagger.model.http_methods.*;

import java.util.ArrayList;
import java.util.List;

public class PathItem implements IPathItem {

    private Get get;

    private Put put;

    private Post post;

    private Delete delete;

    private Options options;

    private Head head;

    private Patch patch;

    private List<IParameter> parameters;





    //getters and setters

    public Get getGet() {
        return get;
    }

    public void setGet(Get get) {
        this.get = get;
    }

    public Put getPut() {
        return put;
    }

    public void setPut(Put put) {
        this.put = put;
    }

    public Patch getPatch() {
        return patch;
    }

    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Delete getDelete() {
        return delete;
    }

    public void setDelete(Delete delete) {
        this.delete = delete;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<IParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<IParameter> parameters) {
        this.parameters = parameters;
    }


    //method to add parameter or reference to "parameters" list
    public void addParameter(IParameter parameter){
        if(parameters == null){
            parameters =  new ArrayList<IParameter>();
        }
        parameters.add(parameter);
    }
}
