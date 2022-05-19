
package com.example.io_backend.model.pojo;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Resource {

    @SerializedName("__type")
    @Expose
    private String type;
    @SerializedName("destinations")
    @Expose
    private List<Destination> destinations = null;
    @SerializedName("origins")
    @Expose
    private List<Origin> origins = null;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Origin> getOrigins() {
        return origins;
    }

    public void setOrigins(List<Origin> origins) {
        this.origins = origins;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Resource.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("destinations");
        sb.append('=');
        sb.append(((this.destinations == null)?"<null>":this.destinations));
        sb.append(',');
        sb.append("origins");
        sb.append('=');
        sb.append(((this.origins == null)?"<null>":this.origins));
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
