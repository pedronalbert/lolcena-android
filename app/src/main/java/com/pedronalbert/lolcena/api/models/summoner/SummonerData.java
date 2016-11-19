package com.pedronalbert.lolcena.api.models.summoner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "profileIconId",
        "summonerLevel",
        "region",
        "message"
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
    @JsonProperty("message")
    public String message;

}