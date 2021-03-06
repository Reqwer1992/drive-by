package calories.tracker.app.dto;

import calories.tracker.app.model.Drive;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alex on 15.30.12.
 */
public class DriveDTO {
    private Long id;
    private String title;
    private String driveFrom;
    private String driveTo;
    private String fromAddress;
    private String toAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "CET")
    private Date departureTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "CET")
    private Date arrivalTime;

    private String text;
    private Double price;
    private String carRegNumber;
    private Integer placesLeft;
    private Integer placesOverall;

    public DriveDTO(){}

    public DriveDTO(Long id, String title, String driveFrom, String driveTo, String fromAddress, String toAddress, Date departureTime, Date arrivalTime,
                   String text, Double price, String carRegNumber, Integer placesLeft, Integer placesOverall) {
        this.id = id;
        this.title = title;
        this.driveFrom = driveFrom;
        this.driveTo = driveTo;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.text = text;
        this.price = price;
        this.carRegNumber = carRegNumber;
        this.placesLeft = placesLeft;
        this.placesOverall = placesOverall;
    }

    public static DriveDTO mapFromDriveEntity(Drive drive) {
        return new DriveDTO(drive.getId(), drive.getTitle(), drive.getDriveFrom(), drive.getDriveTo(), drive.getFromAddress(), drive.getToAddress(),
                drive.getDepartureTime(), drive.getArrivalTime(), drive.getText(), drive.getPrice(), drive.getCarRegNumber(),
                drive.getPlacesLeft(), drive.getPlacesOverall());
    }

    public static List<DriveDTO> mapFromDrivesEntities(List<Drive> drives) {
        return drives.stream().map((drive) -> mapFromDriveEntity(drive)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDriveFrom() {
        return driveFrom;
    }

    public void setDriveFrom(String driveFrom) {
        this.driveFrom = driveFrom;
    }

    public String getDriveTo() {
        return driveTo;
    }

    public void setDriveTo(String driveTo) {
        this.driveTo = driveTo;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    public Integer getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(Integer placesLeft) {
        this.placesLeft = placesLeft;
    }

    public Integer getPlacesOverall() {
        return placesOverall;
    }

    public void setPlacesOverall(Integer placesOverall) {
        this.placesOverall = placesOverall;
    }


}
