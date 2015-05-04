package futbol5



import spock.lang.*

/**
 *
 */
class CanchaPersistenceSpec extends Specification {

    def canchaService

    def setup() {
    }

    def cleanup() {
    }

    void "crud de canchas"() {
            //List
            when:
    		def canchas = canchaService.list()
    		then:
    		def count = canchas.size()

    		//Create
    		when:
    		def c = new Cancha()
    		canchaService.save(c)

    		then:
    		assert canchaService.list().size() == count + 1

    		//Update
    		when:
    		c.wasHeads = !c.wasHeads
    		canchaService.save(c)

    		then:
    		assert canchasService.list().size() == count + 1

    		// Delete
    		when:
    		canchaService.delete(c)
    		then:
    		assert canchaService.list().size() == count
    }
}
