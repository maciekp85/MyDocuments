import com.apress.isf.java.model.Document
import com.apress.isf.spring.data.DocumentRepository
import com.apress.isf.spring.service.SearchEngineService

beans {

    engine(SearchEngineService) { bean ->
        bean.scope = "prototype"
        documentDAO = ref("documentDAO")
    }

    documentDAO(DocumentRepository) { bean ->
        bean.scope = "prototype"
        doc1 = ref("doc1")
        doc2 = ref("doc2")
        doc3 = ref("doc3")
        doc4 = ref("doc4")
    }

    doc1(Document) {
        name = "Szablon książki"
        type = ref("pdfType")
        location = "/Users/felipeg/Documents/Random/Book Template.pdf"
    }

    doc2(Document) {
        name = "Przykładowa umowa"
        type = ref("pdfType")
        location = "/Users/felipeg/Documents/Contracts/Sample Contract.pdf"
    }

    doc3(Document) {
        name = "Clustering with RabbitMQ"
        type = ref("noteType")
        location = "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"
    }

    doc4(Document) {
        name = "Pro Spring Security Book"
        type = ref("webType")
        location = "http://www.apress.com/9781430248187"
    }

    webType(com.apress.isf.java.model.Type) {
        name = "WEB"
        desc = "Lacze sieciowe"
        extension = ".url"
    }

    pdfType(com.apress.isf.java.model.Type) {
        name = "PDF"
        desc = "Portable Document Format"
        extension = ".pdf"
    }

    noteType(com.apress.isf.java.model.Type) {
        name = "NOTE"
        desc = "Notatki tekstowe"
        extension = ".txt"
    }




}