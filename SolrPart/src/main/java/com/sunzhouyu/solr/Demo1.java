package com.sunzhouyu.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author sunyi
 * @Date: 2019/1/10
 */
public class Demo1 {
    @Test
    public void testAdd() throws Exception {
        //solr4创建方式
        //SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8080/solr");
        //solr5创建方式,在url中指定core名称：core1
        //HttpSolrClient solrServer=new HttpSolrClient("http://127.0.0.1:8080/solr/core1");
        //solr7创建方式,在url中指定core名称：core1
        HttpSolrClient solrServer = new HttpSolrClient.Builder("http://127.0.0.1:8983/solr/new_core").build();
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id", "10013");
        document.setField("aaa", "232");
        solrServer.add(document);
        solrServer.commit();
    }

    @Test
    public void testQuery() throws Exception {
        HttpSolrClient solrServer = new HttpSolrClient.Builder("http://127.0.0.1:8983/solr/new_core").build();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("q", "id:100*");
        QueryResponse queryResponse = solrServer.query(solrQuery);
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        for (SolrDocument solrDocument : solrDocumentList) {
            System.out.println((String) solrDocument.get("id"));
        }

    }

    @Test
    public void testDel() throws Exception {
        HttpSolrClient solrServer = new HttpSolrClient.Builder("http://127.0.0.1:8983/solr/new_core").build();
        solrServer.deleteById("1000");
        solrServer.commit();
    }
}
