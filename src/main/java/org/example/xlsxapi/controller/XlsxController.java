package org.example.xlsxapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.example.xlsxapi.exception.ArgumentNumberException;
import org.example.xlsxapi.service.XlsxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class XlsxController {

    private final XlsxService xlsxService;

    public XlsxController(XlsxService xlsxService) {
        this.xlsxService = xlsxService;
    }

    @Operation(summary = "get min from xlsx")
    @GetMapping("/findMin")
    public int findMin(@RequestParam String filePath, @RequestParam int n) throws Exception {
        log.info("Received GET request to fetch xlsx");
        return xlsxService.findMin(filePath, n);
    }

    @ExceptionHandler(ArgumentNumberException.class)
    public ResponseEntity<String> handleArgumentNumbersException(ArgumentNumberException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
