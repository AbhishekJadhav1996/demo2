package com.cybage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Promocode;
import com.cybage.service.PromocodeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/promocode")
public class PromocodeController {
	
		@Autowired
		PromocodeService promocodeService;
		
		@GetMapping("/{promocodeId}")
		public ResponseEntity<?> findById(@PathVariable("promocodeId") int promocodeId) {
			Promocode promocode = promocodeService.findById(promocodeId);
			Map<String, Object> map = new HashMap<>();
			map.put("status", "success");
			map.put("data", promocode);
			return ResponseEntity.ok(map);
		}
		
		@PostMapping("/add")
		public ResponseEntity<Promocode> save(@RequestBody Promocode promocode) {
			promocode = promocodeService.addPromocode(promocode);
			return ResponseEntity.ok(promocode);
			
		}
		
		@GetMapping("/all")
		public ResponseEntity<List<Promocode>> findAll() {
			List<Promocode> list = promocodeService.getAllPromocodes();
			return ResponseEntity.ok(list);
			
		}	

		
		@PutMapping("update/{promocodeId}")
		public ResponseEntity<Promocode> update(@PathVariable("promocodeId") int promocodeId, @RequestBody Promocode promocode) {
			promocode.setPromocodeId(promocodeId);
			Promocode modPromocode = promocodeService.updatePromocode(promocode);
			return ResponseEntity.ok(modPromocode);
		}
		

		@DeleteMapping("deletePromocode/{promocodeId}")
		public ResponseEntity<Boolean> delete(@PathVariable("promocodeId") int promocodeId) {
			boolean success = promocodeService.deleteById(promocodeId);
			return ResponseEntity.ok(success);
		}
		
		@DeleteMapping("/deleteAll")
		public ResponseEntity<Boolean> deleteAll() {
			boolean success = promocodeService.deleteAll();
			return ResponseEntity.ok(success);
		}
	

}
