package com.audit.agriin.Domains.Entities.Common;



import com.audit.agriin.Domains.Entities.Corporate.Corporation;
import com.audit.agriin.Domains.Entities.NonCorporate.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ImageStorage extends AbstractEntity<UUID>{

    @OneToOne
    private Corporation corporation;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "storage", fetch = jakarta.persistence.FetchType.LAZY)
    private List<Image> images = new ArrayList<>();
}
