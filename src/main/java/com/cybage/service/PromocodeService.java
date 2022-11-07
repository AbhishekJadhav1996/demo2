package com.cybage.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.PromocodeDao;
import com.cybage.model.Promocode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PromocodeService {

		@Autowired
		private PromocodeDao promocodeDao;

		public Promocode addPromocode(Promocode promocode) {
			return promocodeDao.save(promocode);
		}

		public List<Promocode> getAllPromocodes() {
			List<Promocode> promocodes = new ArrayList<Promocode>();
			promocodeDao.findAll().forEach(promocode1 -> promocodes.add(promocode1));
			return promocodes;
		}

		public Promocode updatePromocode(Promocode promocode) {
			return promocodeDao.save(promocode);
		}

		public boolean deleteById(int promocodeId) {
			if (promocodeDao.existsById(promocodeId)) {
				promocodeDao.deleteById(promocodeId);
				return true;
			}
			return false;
		}

		public Promocode findById(int id) {
			Optional<Promocode> promocode = promocodeDao.findById(id);
			return promocode.orElse(null);
		}
		
		public boolean deleteAll() {
			promocodeDao.deleteAll();
			return false;
		}
	

}
