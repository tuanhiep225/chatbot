/**
 * 
 */
package com.xmartech.chatbot.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.xmartech.chatbot.model.InformationRequestModel;

/**
 * @author tuanhiep225
 *
 */
@Repository
public interface InformationRequestModelRepository extends BaseRepository<InformationRequestModel, String>{
    @Query(value = "{'ref': ?0}")
    InformationRequestModel getInformationRequestModelByRef(String ref);
}
