package finaktiva.mapper;

public interface IMapper<I, O> {
    O map(final I in);

    I iMap(final O out);
}
