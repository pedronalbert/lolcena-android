package com.pedronalbert.lolcena.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "name",
        "profileIconId",
        "summonerLevel",
        "region"
})
public class SummonerData implements Parcelable{

    public SummonerData () {
        //Constructor required by jackson
    }

    public SummonerData (Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.profileIconId);
        parcel.writeInt(this.summonerLevel);
        parcel.writeString(this.region);
    }

    private void readFromParcel (Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.profileIconId = in.readInt();
        this.summonerLevel = in.readInt();
        this.region = in.readString();
    }

    public static final Parcelable.Creator<SummonerData> CREATOR
            = new Parcelable.Creator<SummonerData>() {
        public SummonerData createFromParcel(Parcel in) {
            return new SummonerData(in);
        }

        @Override
        public SummonerData[] newArray(int i) {
            return new SummonerData[i];
        }
    };

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("profileIconId")
    public Integer profileIconId;
    @JsonProperty("summonerLevel")
    public Integer summonerLevel;
    @JsonProperty("region")
    public String region;

}