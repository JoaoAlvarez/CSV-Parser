package br.com.sefin.service.dto.csv;

import br.com.sefin.service.dto.RoomDTO;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import java.math.BigDecimal;
import java.time.*;

public class HostelResultCSV extends ExportCSV {

    @CsvBindByPosition(position = 0)
    @CsvBindByName(column = "Hotel")
    private String hotel;

    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "Check-in")
    private LocalDate checkInDate;

    @CsvBindByPosition(position = 2)
    @CsvBindByName(column = "Check-out")
    private LocalDate checkOutDate;

    @CsvBindByPosition(position = 3)
    @CsvBindByName(column = "Data alvo (dias)")
    private Long targetDateInterval;

    @CsvBindByPosition(position = 4)
    @CsvBindByName(column = "Avaliação")
    private Integer rating;

    @CsvBindByPosition(position = 5)
    @CsvBindByName(column = "Acomoda")
    private Integer numberOfPeople;

    @CsvBindByPosition(position = 6)
    @CsvBindByName(column = "Valor")
    private BigDecimal price;

    @CsvBindByPosition(position = 7)
    @CsvBindByName(column = "Cafe da manha")
    private Boolean breakfastIncluded;

    @CsvBindByPosition(position = 8)
    @CsvBindByName(column = "Taxa inclusa")
    private Boolean taxesIncluded;

    @CsvBindByPosition(position = 9)
    @CsvBindByName(column = "Valido")
    private Boolean valid;

    @CsvBindByPosition(position = 10)
    @CsvBindByName(column = "Data Captura")
    private ZonedDateTime createdAt;

    public HostelResultCSV(RoomDTO dto) {
        this.hotel = dto.getHotelResult().getName();
        this.checkInDate = dto.getCheckInDate();
        this.checkOutDate = dto.getCheckOutDate();
        this.rating = dto.getHotelResult().getRating();
        this.numberOfPeople = dto.getNumberOfPeople();
        this.price = dto.getPrice();
        this.breakfastIncluded = dto.getBreakfastIncluded();
        this.taxesIncluded = dto.getTaxesIncluded();
        this.valid = dto.getValid();
        this.createdAt = dto.getCreatedAt();

        Duration period = Duration.between(
            createdAt.withZoneSameLocal(ZONE_ID),
            checkInDate.atTime(createdAt.getHour() - 1, createdAt.getMinute()).atZone(ZONE_ID)
        );
        this.targetDateInterval = period.toDays();
    }

    public String getHotel() {
        return hotel;
    }

    public String getCheckInDate() {
        return checkInDate.format(DATE_FORMAT);
    }

    public String getCheckOutDate() {
        return checkOutDate.format(DATE_FORMAT);
    }

    public Long getTargetDateInterval() {
        return targetDateInterval;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getBreakfastIncluded() {
        return breakfastIncluded != null ? breakfastIncluded ? "Sim" : "Nao" : " - ";
    }

    public String getTaxesIncluded() {
        return taxesIncluded != null ? taxesIncluded ? "Sim" : "Nao" : " - ";
    }

    public String getValid() {
        return valid != null ? valid ? "Sim" : "Nao" : " - ";
    }

    public String getCreatedAt() {
        return createdAt.format(DATE_TIME_FORMAT);
    }

    public HostelResultCSV hotel(String hotel) {
        this.hotel = hotel;
        return this;
    }

    public HostelResultCSV checkInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        return this;
    }

    public HostelResultCSV checkOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
        return this;
    }

    public HostelResultCSV rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public HostelResultCSV numberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        return this;
    }

    public HostelResultCSV price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public HostelResultCSV breakfastIncluded(Boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
        return this;
    }

    public HostelResultCSV taxesIncluded(Boolean taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
        return this;
    }

    public HostelResultCSV valid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public HostelResultCSV createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
