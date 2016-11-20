package com.pedronalbert.lolcena.api.models;

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
public class SummonerData {

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