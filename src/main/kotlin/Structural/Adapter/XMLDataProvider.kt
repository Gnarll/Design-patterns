package org.example.Structural.Adapter

// this class emulates xml data fetching

class XMLDataProvider {
    companion object {
        private val MOCK_XML_STRING: String = """
            <root>
                <transaction>
                    <type>Transfer of funds</type>
                    <id>3254213213</id>
                    <sum>
                        <currency>mark</currency>
                        <value>1000</value>
                    </sum>
                    <sender>
                        <name>Otto Köster</name> 
                    </sender>
                    <recipient>
                        <name>Robert Lohkamp</name>
                    </recipient>
                </transaction>
            </root>
        """

         fun fetchData(): String {
            return MOCK_XML_STRING
        }
    }
}