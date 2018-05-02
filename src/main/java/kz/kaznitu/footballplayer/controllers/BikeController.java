package kz.kaznitu.footballplayer.controllers;

import kz.kaznitu.footballplayer.models.Bike;
import kz.kaznitu.footballplayer.models.MadeIn;
import kz.kaznitu.footballplayer.repositories.BikeRepository;
import kz.kaznitu.footballplayer.repositories.MadeInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BikeController {
    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private MadeInRepository madeInRepository;

    @RequestMapping(value = "/bikes", method = RequestMethod.GET)
    public String bikesList(Model model){
        model.addAttribute("bikes", bikeRepository.findAll());
        model.addAttribute("madeIns", madeInRepository.findAll());
        return "bikes";
    }

    @RequestMapping(value = "/bikes",method = RequestMethod.POST)
    public String addBike(@RequestParam Long madeInIId,
                            @RequestParam String bikeModel,
                            @RequestParam String bikeColor,
                            @RequestParam int bikeYear,
                            Model model) {
        MadeIn madeIn = madeInRepository.findById(madeInIId).get();
        Bike newBike= new Bike();
        newBike.setMadeIn(madeIn);
        newBike.setBikeModel(bikeModel);
        newBike.setBikeColor(bikeColor);
        newBike.setBikeYear(bikeYear);
        bikeRepository.save(newBike);

        return "redirect:/bikes";
    }


    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") Long id){
        bikeRepository.deleteById(id);
        return "redirect:/bikes";
    }

}
