package com.github.vjuge.cdmdsl.generator

import com.squareup.kotlinpoet.FileSpec
import io.github.classgraph.ClassGraph
import io.github.classgraph.ScanResult

abstract class Generator {
    abstract val PACKAGE : String
    abstract val CLASS : String
    abstract val CDM_PKG : Array<String>

    val scanResult : ScanResult by lazy {
        ClassGraph()
            .enableAllInfo()
            .acceptPackages(*CDM_PKG)
            .scan()
    }

    abstract fun generate(): FileSpec
}