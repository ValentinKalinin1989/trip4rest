package com.senla.tripstorage.model.mapper;

import com.senla.tripstorage.model.entity.Chat;
import com.senla.tripstorage.model.dto.ChatDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ChatMapper {
    ChatDTO chatToChatDTO(Chat chat);
    Chat chatDTOtoChat(ChatDTO chatDTO);
}
