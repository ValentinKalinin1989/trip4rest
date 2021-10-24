package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Message;
import com.senla.tripstorage.model.dto.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO messageToMessageDTO(Message message);
    Message messageDTOtoMessage(MessageDTO messageDTO);
}
