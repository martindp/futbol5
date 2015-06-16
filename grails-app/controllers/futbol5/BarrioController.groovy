package futbol5

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.rest.RestfulController


@Transactional(readOnly = true)
class BarrioController  extends RestfulController {

   static responseFormats = ['json', 'xml']
   static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

       BarrioController(){
   	    super(Barrio)
       }
   def beforeInterceptor = {
        response.setHeader('Access-Control-Allow-Origin', '*')
                           response.setHeader('Access-Control-Allow-Methods', 'POST, PUT, GET, OPTIONS, PATCH')
                           response.setHeader('Access-Control-Allow-Headers', 'X-Additional-Headers-Example')
                           response.setHeader('Access-Control-Allow-Credentials', 'true')
                           response.setHeader('Access-Control-Max-Age', '1728000')
   }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Barrio.list(params), model:[barrioInstanceCount: Barrio.count()]
    }

    def show(Barrio barrioInstance) {
        respond barrioInstance
    }

    def create() {
        respond new Barrio(params)
    }

    @Transactional
    def save(Barrio barrioInstance) {
        if (barrioInstance == null) {
            notFound()
            return
        }

        if (barrioInstance.hasErrors()) {
            respond barrioInstance.errors, view:'create'
            return
        }

        barrioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'barrio.label', default: 'Barrio'), barrioInstance.id])
                redirect barrioInstance
            }
            '*' { respond barrioInstance, [status: CREATED] }
        }
    }

    def edit(Barrio barrioInstance) {
        respond barrioInstance
    }

    @Transactional
    def update(Barrio barrioInstance) {
        if (barrioInstance == null) {
            notFound()
            return
        }

        if (barrioInstance.hasErrors()) {
            respond barrioInstance.errors, view:'edit'
            return
        }

        barrioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Barrio.label', default: 'Barrio'), barrioInstance.id])
                redirect barrioInstance
            }
            '*'{ respond barrioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Barrio barrioInstance) {

        if (barrioInstance == null) {
            notFound()
            return
        }

        barrioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Barrio.label', default: 'Barrio'), barrioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'barrio.label', default: 'Barrio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
