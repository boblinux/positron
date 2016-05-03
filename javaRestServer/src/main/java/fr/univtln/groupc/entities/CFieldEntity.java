package fr.univtln.groupc.entities;


import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpesnel786 on 26/04/16.
 */

@Entity
@Table(name = "t_field", schema = "positron")
@NamedQueries(@NamedQuery(name = CFieldEntity.GET_ALL, query = "select f from CFieldEntity f"))
public class CFieldEntity {
    @Id
    @Column(name = "field_id")
    private int mId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "territory_fk")
    @JsonIgnore
    private CTerritoryEntity mTerritory;
    @OneToMany(mappedBy="mField")
    @JsonIgnore
    private List<CLinkEntity> mLinks = new ArrayList<CLinkEntity>();

    public final static String GET_ALL = "Field.getAll";

    public CFieldEntity() {}

    public CFieldEntity(CFieldBuilder pBuilder){
        mId = pBuilder.mId;
    }

    public static class CFieldBuilder{
        private int mId;

        public CFieldBuilder(int pId) {
            mId = pId;
        }

        public CFieldEntity build(){
            return new CFieldEntity((this));
        }
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public CTerritoryEntity getmTerritory() {
        return mTerritory;
    }

    public void setmTerritory(CTerritoryEntity mTerritory) {
        this.mTerritory = mTerritory;
    }

    @JsonIgnore
    public List<CLinkEntity> getmLinks() {
        return mLinks;
    }

    public void addmLinks(CLinkEntity pLink){
        mLinks.add(pLink);
        pLink.setmField(this);
    }

    public void delmLinks(CLinkEntity pLink){
        mLinks.remove(pLink);
        pLink.setmField(null);
    }
}