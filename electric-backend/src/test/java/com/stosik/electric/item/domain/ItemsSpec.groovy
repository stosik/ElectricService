package com.stosik.electric.item.domain

import org.apache.tomcat.util.http.fileupload.FileItemStream.ItemSkippedException
import spock.lang.Specification

class ItemsSpec extends Specification implements SampleItems
{
    def "should show a item"()
    {
        given:

        "film is in the system"
        facade.add(trumper)

        expect:

        "system return the film"
        facade.show(trumper.title) == trumper
    }

    def "should successfully add comment to item"()
    {

    }

    def "should successfully report malfunction of the item"()
    {

    }

    def "should throw exception when asked for a item that's not in the system"()
    {
        when:

        "system is asked for a film that is not present"
        facade.show("some title we don't have")

        then:

        thrown(ItemSkippedException)
    }
}
