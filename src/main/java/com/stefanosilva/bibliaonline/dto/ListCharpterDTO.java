package com.stefanosilva.bibliaonline.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListCharpterDTO {
   private BookDTO book;
   private List<Integer> charpters;

}
