package com.apress.isf.groovy.service

import com.apress.isf.groovy.model.Type

/**
 * Created by nishi on 2016-03-29.
 */
interface SearchEngine {
    def findByType(Type documentType)
    def listAll()
}