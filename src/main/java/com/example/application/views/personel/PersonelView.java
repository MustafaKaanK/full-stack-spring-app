package com.example.application.views.personel;

import com.example.application.model.Personel;
import com.example.application.service.PersonelService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import java.util.List;

@PageTitle("Personel")
@Route(value = "Personel", layout = MainLayout.class)
@SpringComponent
@UIScope
public class PersonelView extends VerticalLayout {

    @Autowired
    private PersonelService personelService;

    private Grid<Personel> grid;
    private TextField textField;
    private ListDataProvider<Personel> dataProvider;

    public PersonelView() {
        setSpacing(true);
        setAlignItems(Alignment.START);

        // Text field
        textField = new TextField("Search by Ad:");
        textField.addValueChangeListener(event -> filterGrid(event.getValue()));
        add(textField);

        // Grid Elements
        Div gridContainer = new Div();
        gridContainer.getStyle().set("width", "100%"); 
        add(gridContainer);

        grid = new Grid<>();
        grid.addColumn(Personel::getAd).setHeader("Ad");
        grid.addColumn(Personel::getSoyad).setHeader("Soyad"); 
        grid.getStyle().set("height", "54vh");    

        gridContainer.add(grid);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
    }

    @PostConstruct
    public void init() {
        List<Personel> personelList = personelService.getAllPersonnel();
        dataProvider = new ListDataProvider<>(personelList);
        grid.setDataProvider(dataProvider);
    }

    private void filterGrid(String filterText) {
        dataProvider.setFilter(personel -> 
            personel.getAd().toLowerCase().contains(filterText.toLowerCase()));
    }
}
