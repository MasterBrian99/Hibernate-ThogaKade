package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.ItemBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOTypes;
import lk.ijse.hibernate.dao.custom.impl.ItemDAOImpl;
import lk.ijse.hibernate.dto.CustomerDTO;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAOImpl itemDAO= DAOFactory.getInstance().getDAO(DAOTypes.ITEM);
    @Override
    public ItemDTO find(String s) throws Exception {

            Item item=itemDAO.find(s);
            ItemDTO itemDTO=new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());

        return itemDTO;
    }

    @Override
    public long getCount() throws Exception {
        return itemDAO.getAll();

    }

    @Override
    public List<ItemDTO> findAll() throws Exception {

        List<Item> all = itemDAO.findAll();
        List<ItemDTO> itemDTOS=new ArrayList<>();

        for (Item i : all) {
            ItemDTO itemDTO=new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand());
            itemDTOS.add(itemDTO);
        }
            return itemDTOS;
    }


}
