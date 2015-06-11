package futbol5



import grails.test.mixin.*
import spock.lang.*

@TestFor(BarrioController)
@Mock(Barrio)
class BarrioControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.barrioInstanceList
            model.barrioInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.barrioInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def barrio = new Barrio()
            barrio.validate()
            controller.save(barrio)

        then:"The create view is rendered again with the correct model"
            model.barrioInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            barrio = new Barrio(params)

            controller.save(barrio)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/barrio/show/1'
            controller.flash.message != null
            Barrio.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def barrio = new Barrio(params)
            controller.show(barrio)

        then:"A model is populated containing the domain instance"
            model.barrioInstance == barrio
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def barrio = new Barrio(params)
            controller.edit(barrio)

        then:"A model is populated containing the domain instance"
            model.barrioInstance == barrio
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/barrio/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def barrio = new Barrio()
            barrio.validate()
            controller.update(barrio)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.barrioInstance == barrio

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            barrio = new Barrio(params).save(flush: true)
            controller.update(barrio)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/barrio/show/$barrio.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/barrio/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def barrio = new Barrio(params).save(flush: true)

        then:"It exists"
            Barrio.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(barrio)

        then:"The instance is deleted"
            Barrio.count() == 0
            response.redirectedUrl == '/barrio/index'
            flash.message != null
    }
}
