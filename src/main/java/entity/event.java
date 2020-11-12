package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class event {
    private int id;
    private String name;
    private String location;
    public event(String name, String location) {
        this.name=name;
        this.location=location;
    }
    public event(int id) {
        this.id = id;
    }
}
