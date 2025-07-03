package com.techcompany.device.loan.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_name", nullable = false)
    @Size(max = 100)
    private String deviceName;

    @Column(name = "device_type", nullable = false)
    @Size(max = 100)
    private String deviceType;

    @Column(nullable = false)
    @Size(max = 100)
    private String brand;

    @Column(nullable = false)
    @Size(max = 100)
    private String model;

    @Column(name = "serial_number", nullable = false)
    @Size(max = 100)
    private String serialNumber;

    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @Column(nullable = false)
    @Size(max = 50)
    private String status;
}
