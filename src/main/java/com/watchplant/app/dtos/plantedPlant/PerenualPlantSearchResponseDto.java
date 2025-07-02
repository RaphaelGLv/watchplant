package com.watchplant.app.dtos.plantedPlant;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class PerenualPlantSearchResponseDto {
    private List<PerenualPlantDetailsDto> data = new ArrayList<>();
    @JsonProperty("to")
    private Integer to;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("current_page")
    private Integer currentPage;
    @JsonProperty("from")
    private Integer from;
    @JsonProperty("last_page")
    private Integer lastPage;
    @JsonProperty("total")
    private Integer total;

    public List<PerenualPlantDetailsDto> getData() { return data; }
    public void setData(List<PerenualPlantDetailsDto> data) { this.data = data; }
    public void addPlant(PerenualPlantDetailsDto plant) { this.data.add(plant); }

    public Integer getTo() { return to; }
    public void setTo(Integer to) { this.to = to; }
    public Integer getPerPage() { return perPage; }
    public void setPerPage(Integer perPage) { this.perPage = perPage; }
    public Integer getCurrentPage() { return currentPage; }
    public void setCurrentPage(Integer currentPage) { this.currentPage = currentPage; }
    public Integer getFrom() { return from; }
    public void setFrom(Integer from) { this.from = from; }
    public Integer getLastPage() { return lastPage; }
    public void setLastPage(Integer lastPage) { this.lastPage = lastPage; }
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }
}
