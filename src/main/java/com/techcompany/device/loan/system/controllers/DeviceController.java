package com.techcompany.device.loan.system.controllers;

import com.techcompany.device.loan.system.model.Device;
import com.techcompany.device.loan.system.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping()
    public ResponseEntity<Device> createDevice(@RequestBody @Valid Device device) {
        Device createdDevice = deviceService.createDevice(device);
        return ResponseEntity.created(URI.create("/devices/" + createdDevice.getId())).body(createdDevice);
    }

    @GetMapping()
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody @Valid Device updatedDevice) {
        return ResponseEntity.ok(deviceService.updateDevice(id, updatedDevice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}