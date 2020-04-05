
package com.losingtimeapps.testionix.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.losingtimeapps.testionix.domain.model.Result;

public class DataModel {

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("result")
    @Expose
    private Result result;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
