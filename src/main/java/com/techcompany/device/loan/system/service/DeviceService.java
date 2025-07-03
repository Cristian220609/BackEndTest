package com.techcompany.device.loan.system.service;

import com.techcompany.device.loan.system.model.Device;
import com.techcompany.device.loan.system.repository.DeviceRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device createDevice(@Valid Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device updateDevice(Long id, @Valid Device updatedDevice) {
        Device device = deviceRepository.findById(id).orElse(null);
        if (device != null) {
            device.setDeviceName(updatedDevice.getDeviceName());
            device.setDeviceType(updatedDevice.getDeviceType());
            device.setSerialNumber(updatedDevice.getSerialNumber());
            device.setBrand(updatedDevice.getBrand());
            device.setModel(updatedDevice.getModel());
            device.setStatus(updatedDevice.getStatus());
            return deviceRepository.save(device);
        }
        return null;
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

}
