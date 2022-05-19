
package com.example.io_backend.model.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {

    @SerializedName("destinationIndex")
    @Expose
    private Integer destinationIndex;
    @SerializedName("originIndex")
    @Expose
    private Integer originIndex;
    @SerializedName("totalWalkDuration")
    @Expose
    private Integer totalWalkDuration;
    @SerializedName("travelDistance")
    @Expose
    private Double travelDistance;
    @SerializedName("travelDuration")
    @Expose
    private Double travelDuration;

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }

    public Integer getOriginIndex() {
        return originIndex;
    }

    public void setOriginIndex(Integer originIndex) {
        this.originIndex = originIndex;
    }

    public Integer getTotalWalkDuration() {
        return totalWalkDuration;
    }

    public void setTotalWalkDuration(Integer totalWalkDuration) {
        this.totalWalkDuration = totalWalkDuration;
    }

    public Double getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(Double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public Double getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(Double travelDuration) {
        this.travelDuration = travelDuration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("destinationIndex");
        sb.append('=');
        sb.append(((this.destinationIndex == null)?"<null>":this.destinationIndex));
        sb.append(',');
        sb.append("originIndex");
        sb.append('=');
        sb.append(((this.originIndex == null)?"<null>":this.originIndex));
        sb.append(',');
        sb.append("totalWalkDuration");
        sb.append('=');
        sb.append(((this.totalWalkDuration == null)?"<null>":this.totalWalkDuration));
        sb.append(',');
        sb.append("travelDistance");
        sb.append('=');
        sb.append(((this.travelDistance == null)?"<null>":this.travelDistance));
        sb.append(',');
        sb.append("travelDuration");
        sb.append('=');
        sb.append(((this.travelDuration == null)?"<null>":this.travelDuration));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
