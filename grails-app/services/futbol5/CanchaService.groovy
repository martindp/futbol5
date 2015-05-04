package futbol5

import grails.transaction.Transactional

@Transactional
class CanchaService {

    	List list() {
    		return Cancha.list()
    	}

    	Cancha save(cancha) {
    		cancha.save()
    	}

    	Cancha delete(cancha) {
    		cancha.delete()
    	}
}
